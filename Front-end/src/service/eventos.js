import{ http } from './config'

export default{
    getEventos:()=>{
        return http.get('eventos')
      },
      getEvento:(id)=>{
        console.log(id)
        return http.get('eventos/' + id)
       
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
      buscarEvento:(nomepesquisa)=>{
        return http.get('/pesquisar', {params:{nomepesquisa}})
      }
}