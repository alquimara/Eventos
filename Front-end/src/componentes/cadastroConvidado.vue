<template>
<div>
     <nav>
    <div class="nav-wrapper cor">
      <a href="#" class="brand-logo center">Cadastrar Convidado</a>
    </div>
  </nav>
        
    <div class="container" style="margin-top:30px">
      <form @submit.prevent="saveConvidado">
        <input type="hidden" />
        Nome
        <input v-model="convidado.nome" type="text" />
        <br />Email
        <input v-model="convidado.email" type="text" />
        <br />RG
        <input v-model="convidado.rg" type="text" size="11" />
        <br />
        <button style="margin-left:990px" class="btn waves-effect cor" type="submit">
          salvar
         <i class="material-icons right">save</i>
        </button>
      </form>
    </div>
</div>
</template>
<script>
import Convidado from "./../service/convidado.js";
import convidados from "./../service/convidado.js";
export default {
  
  data() {
    return {
      convidado: {
        id: this.$store.state.convidado.id,
        nome: this.$store.state.convidado.nome,
        email: this.$store.state.convidado.email,
        rg: this.$store.state.convidado.rg
      },
    };
  },
  methods: {
    saveConvidado() {
      if (!this.convidado.id) {
        if (
          this.convidado.nome != "" &&
          this.convidado.email != "" &&
          this.convidado.rg != ""
        ) {
          Convidado.createConvidado(this.convidado, this.$store.state.evento.id).then((response) => {
            this.$store.state.convidado = this.convidado
            this.$store.state.convidado={}
            alert("convidado salvo com sucesso");
            this.$router.push('/convidado')
          });
        } else {
          alert("nenhum campo pode ficar vazio");
        }
      } else {
        Convidado.updateConvidado(this.convidado).then((response) => {
          this.$store.state.convidado = {};
          alert("convidado atualizado com sucesso");
          this.$router.push('/convidado')
        });
      }
    },
  },
};
</script>
<style>
.cor{
  background-color: #7b1fa2;
}
</style>
