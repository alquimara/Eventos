<template>
  <div  class="menu">
    <nav>
      <div class="nav-wrapper cor">
        <div class="nav-wrapper" style="margin-top:16px">
         <router-link  style="margin-left:20px" class="brand-logo" to="/">Events</router-link>
        <a href="#"  style="margin-right:30px" class=" right">{{this.$store.state.evento.nome}}</a>
        <ul class="right hide-on-med-and-down">
        <li><a href="sass.html"><i class="material-icons">explicit</i></a></li>
      </ul>
          <form>
            <div style="margin-left:400px" class="input-field cabecalho">
              <input id="search" placeholder="Buscar" type="search" v-model="nomepesquisa" required />
              <label class="label-icon" for="search">
                <i class="material-icons">search</i>
              </label>
            </div>
          </form>
         
        </div>
      </div>
    </nav>
    <div class="detalhe">
      <h5 style="margin-left:-150px">Informações sobre o evento</h5>
      <div class="informacoes">
      <p>Nome:
        {{this.$store.state.evento.nome}}
      </p>
      <p>Endereço: {{this.$store.state.evento.endereco}}</p>
      <p>Cidade: {{this.$store.state.evento.cidade}}</p>
      </div>
      <div class="informacoes data">
      <p>Data: {{this.$store.state.evento.datae}}</p>
      <p>Horario: {{this.$store.state.evento.horario}}</p>
    </div>
    </div>

    <div class="container" style="width">
      <table>
        <thead>
          <tr>
            <th></th>
            <th>Convidado</th>
            <th>Email</th>
            <th>Rg</th>
            <th>Editar</th>
            <th>Deletar</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="convidado of this.$store.state.convidados" :key="convidado.id">
            <td>
              <i id="coricon" class="material-icons small ">account_circle</i>
            </td>
            <td>{{convidado.nome}}</td>
            <td>{{convidado.email}}</td>
            <td>{{convidado.rg}}</td>
            <td>
              <a @click="updateConvidado(convidado)" class="mouse">
                <i id="coredite" class="material-icons">edit</i>
              </a>
            </td>
            <td>
              <a @click="deleteConvidado(convidado)" class="mouse">
                <i id="cordelete" class="material-icons">delete</i>
              </a>
            </td>
          </tr>
        </tbody>
      </table>
       <router-link to="/cadastroconvidado"  style="margin-left:95%" class="btn-floating btn-large waves-effect waves-light cor" >
                <i class="material-icons">add</i></router-link>
    </div>
    <!-- formulario -->
  </div>
</template>
<script>

import Convidado from "./../service/convidado.js";
import convidados from "./../service/convidado.js";
export default {
  data() {
    return {
      nomepesquisa: "",
      modalativo: true,
      // contatos: [],
    };
  },
  mounted() {
    this.getConvidados();
  },

  computed: {
    buscar() {
      return this.nomepesquisa;
    },
  },
  watch: {
    buscar() {
      this.buscarConvidado();
    },
  },
  methods: {

    getConvidados() {
      Convidado.getConvidados(this.$store.state.evento.id).then((response) => {
      this.$store.state.convidados= response.data;
      });
    },
    buscarConvidado() {
      Convidado.buscarConvidado(this.nomepesquisa).then((response) => {
        this.$store.state.convidados = response.data;
      });
    },
    updateConvidado(convidado) {
      this.$store.state.convidado = convidado;
      this.$router.push('/cadastroconvidado')
    },
    detalheConvidado(convidado){
      this.$store.state.convidado = convidado;
      this.$router.push('/convidado')
    },
    deleteConvidado(convidado) {
      Convidado.deleteConvidado(convidado).then((response) => {
        this.getConvidados();
      });
    },
  },
};
</script>
<style>
.cabecalho {
  width: 500px;
}
.menu {
  margin-top: -20px;
}
.cor{
  background-color: #7b1fa2;
}
#coricon{
  color:#7b1fa2
}
.mouse{
  cursor: pointer;
}
#cordelete{
  color: #e53935
}
#coredit{
  color: #1e88e5
}
.detalhe{
  width: 800px;
  height: 200px;

  margin-left: 450px;
  margin-top: 20px;
  margin-bottom: 10px;
  text-align: center;
}
.informacoes{
  margin-top: 50px;
  width: 300px;
  position: absolute;
}
.texto-negrito{
  font-weight: bold
}
.data{
  margin-left: 350px
}

</style>
