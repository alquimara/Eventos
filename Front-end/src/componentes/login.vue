<template>
<div>
     <nav>
    <div class="nav-wrapper cor">
      <a href="#" class="brand-logo center">Login</a>
    </div>
  </nav>
        
    <div class="container" style="margin-top:30px">
      <form @submit.prevent="login">
          Email
        <input v-model="usuario.email" type="email" />
        <br />Senha
        <input v-model="usuario.senha" type="password" />
        <br />
        <router-link  to="/cadastrousuario"><button  class="btn waves-effect cor" type="submit">
          Cadastrar-se
        </button>
        </router-link>
        <button style="margin-left:850px" class="btn waves-effect cor" type="submit">
          Login
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
        email: "",
        senha: ""
      },
      usuarios:[]
    };
  },
   mounted() {
    this.mostrarUsuarios();
  },
  methods: {
   mostrarUsuarios() {
    Usuario.listaUsuario().then((response)=>{
    this.$store.state.usuarios = response.data
    this.usuarios =  this.$store.state.usuarios;
    })
  },
  login(){
    for(let u=0; u<this.usuarios.length; u++){
     if(this.usuarios[u].email == this.usuario.email && this.usuarios[u].senha == this.usuario.senha){
       this.$store.state.usuario = this.usuarios[u]
       console.log(this.usuarios[u].email == this.usuario.email && this.usuarios[u].senha == this.usuario.senha)
       this.$router.push('/home')

     }
     
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
