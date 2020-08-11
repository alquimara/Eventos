<template>
<div>
     <nav>
    <div class="nav-wrapper cor">
      <a href="#" class="brand-logo center">Cadastro Usuario</a>
    </div>
  </nav>
        
    <div class="container" style="margin-top:30px">
      <form @submit.prevent="login">
          Email
        <input v-model="usuario.email" type="email" />
        <br />Senha
        <input v-model="usuario.senha" type="password" />
        <br />
        <button style="margin-left:990px" class="btn waves-effect cor" type="submit">
          Login
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
        id: "",
        nome: "",
        email: "",
        senha: ""
      },
    };
  },
  methods: {
   login() {
       if(this.usuario == this.$store.state.usuario){
           console.log(this.usuario)
       }
       
  }
}
}
</script>
<style>
.cor{
  background-color: #7b1fa2;
}
</style>
