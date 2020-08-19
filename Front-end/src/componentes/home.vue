<template>
  <div  class="menu">
    <nav>
      <div class="nav-wrapper cor">
        <div class="nav-wrapper" style="margin-top:16px">
       <router-link  style="margin-left:20px" class="brand-logo" to="/">Events</router-link>
        <a  @click="logout()"  style="margin-right:30px" class=" right mouse">{{this.$store.state.usuario.nome}}</a>
        <ul class="right hide-on-med-and-down">
        <li><a ><i class="material-icons">account_circle</i></a></li>
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
    <div class="container" style="width">
      <table>
        <thead>
          <tr>
            <th></th>
            <th>Nome</th>
            <th>Cidade</th>
            <th>Data</th>
            <th>Horario</th>
            <th>Editar</th>
            <th>Deletar</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="evento of this.$store.state.eventos" :key="evento.id" class="mouse">
            <td>
              <i id="coricon" class="material-icons small ">explicit</i>
            </td>
            <td @click="detalheEvento(evento)">{{evento.nome}}</td>
            <td>{{evento.cidade}}</td>
            <td>{{evento.datae}}</td>
             <td>{{evento.horario}}</td>
            <td>
              <a @click="updateEvento(evento)" class="mouse">
                <i id="coredite" class="material-icons">edit</i>
              </a>
            </td>
            <td>
              <a @click="deleteEvento(evento)" class="mouse">
                <i id="cordelete" class="material-icons">delete</i>
              </a>
            </td>
          </tr>
        </tbody>
      </table>
       <a style="margin-left:95%" class="btn-floating btn-large waves-effect waves-light cor" @click="cadastro()">
                <i class="material-icons">add</i></a>
    </div>
    <!-- formulario -->
  </div>
</template>
<script>

import Evento from "./../service/eventos.js";
import eventos from "./../service/eventos.js";
export default {
  data() {
    return {
      nomepesquisa: ""
    };
  },
  mounted() {
    this.getEventos();
  },

  computed: {
    buscar() {
      return this.nomepesquisa;
    },
  },
  watch: {
    buscar() {
      this.buscarEvento();
    },
  },
  methods: {

    getEventos() {
      Evento.getEventos(this.$store.state.usuario.id).then((response) => {
        this.$store.state.eventos= response.data;
      });
    },
    buscarEvento() {
      Evento.buscarEvento(this.nomepesquisa, this.$store.state.usuario.id).then((response) => {
        console.log(this.$store.state.eventos)
      });
    },
    cadastro(){
       this.$store.state.evento = {}
        this.$router.push('/cadastro')
    },
   
    updateEvento(evento) {
      this.$store.state.evento = evento;
      this.$router.push('/cadastro')
    },
    detalheEvento(evento){
      this.$store.state.evento = evento;
      this.$router.push('/convidado')
      
    },
    logout(){
       this.$router.push('/')
       this.$store.state.usuario = {}


    },
    deleteEvento(evento) {
      Evento.deleteEvento(evento).then((response) => {
        this.getEventos();
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
</style>
