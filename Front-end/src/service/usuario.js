import{ http } from './config'

export default{
    
      createUsuario:(usuario)=>{
        return http.post('cadastrarUsuario', usuario)
      },
      listaUsuario:()=>{
        return http.get('usuarios')
      }
}