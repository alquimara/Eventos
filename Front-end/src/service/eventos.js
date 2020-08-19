import{ http } from './config'

export default{
    getEventos:(id)=>{
        return http.get('eventos/', {params:{id}})
      },
      getEvento:(id)=>{
        return http.get('evento/' + id)
       
      },
       createEventoId:(evento, id)=>{
        return http.post('cadastrarevento/' + id, evento)
    
      },
      createEvento:(evento)=>{
        return http.post('cadastrar', evento)
    
      },
      updateEvento:(evento)=>{
        return http.put('atualizar', evento)
      },
      deleteEvento:(evento)=>{
        return http.delete('/excluir', {data:evento})
    
      },
      buscarEvento:(nomepesquisa, id)=>{
        return http.get('/pesquisar/' , {params:{nomepesquisa, id}})
      }
}