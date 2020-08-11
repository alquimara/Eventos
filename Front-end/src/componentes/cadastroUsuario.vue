<template>
<div>
     <nav>
    <div class="nav-wrapper cor">
      <a href="#" class="brand-logo center">Cadastro Usuario</a>
    </div>
  </nav>
        
    <div class="container" style="margin-top:30px">
      <form @submit.prevent="saveUsuario">
        <input type="hidden" />
        Nome
        <input v-model="usuario.nome" type="text" />
        <br />Email
        <input v-model="usuario.email" type="text" />
        <br />Senha
        <input v-model="usuario.rg" type="password" />
        <br />
        <button style="margin-left:990px" class="btn waves-effect cor" type="submit">
          Cadastrar
         <i class="material-icons right">save</i>
        </button>
      </form>
    </div>
</div>
</template>
<script>
import Usuario from "./../service/usuario.js";
import usuarios from "./../service/usuario.js";
export default {
  
  data() {
    return {
      usuario: {
        id: this.$store.state.usuario.id,
        nome: this.$store.state.usuario.nome,
        email: this.$store.state.usuario.email,
        senha: this.$store.state.usuario.senha
      },
    };
  },
  methods: {
    saveUsuario() {
    Usuario.createUsuario(this.usuario).then((response) => {
        this.$store.state.usuario = this.usuario
        alert("Usuario salvo com sucesso");
        this.$router.push('/login')
    });
  }
}
}
</script>
<style>
.cor{
  background-color: #7b1fa2;
}
</style>
