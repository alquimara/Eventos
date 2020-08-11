<template>
<div>
     <nav>
    <div class="nav-wrapper cor">
      <a href="#" class="brand-logo center">Cadastrar Evento</a>
    </div>
  </nav>
        
    <div class="container" style="margin-top:30px">
      <form @submit.prevent="saveEvento">
        <input type="hidden" />
        Nome
        <input v-model="evento.nome" type="text" />
        <br />Endereço
        <input v-model="evento.endereco" type="text" />
        <br />Cidade
        <input v-model="evento.cidade" type="text" />
        <br />Data
        <input v-model="evento.datae" type="date" />
        <br />Horario
         <input v-model="evento.horario" type="time"/>
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
import Evento from "./../service/eventos.js";
import eventos from "./../service/eventos.js";
export default {
  
  data() {
    return {
      evento: {
        id: this.$store.state.evento.id,
        nome: this.$store.state.evento.nome,
        endereco:this.$store.state.evento.endereco,
        cidade:this.$store.state.evento.nome, 
        datae: this.$store.state.evento.datae,
        horario:this.$store.state.evento.horario
      },
    };
  },
  methods: {
    saveEvento() {
      if (!this.evento.id) {
        if (
          this.evento.nome != "" &&
          this.evento.local != "" &&
          this.evento.datae != "" &&
          this.evento.horario != "" &&
          this.evento.endereco != "" &&
          this.evento.cidade != ""
        ) {
          Evento.createEvento(this.evento).then((response) => {
            console.log(this.evento)
            this.$store.state.evento = this.evento
            this.$store.state.evento={}
            alert("evento salvo com sucesso");
            this.$router.push('/')
          });
        } else {
          alert("nenhum campo pode ficar vazio");
        }
      } else {
        Evento.updateEvento(this.evento).then((response) => {
          this.$store.state.evento = {};
          alert("evento atualizado com sucesso");
          this.$router.push('/')
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
