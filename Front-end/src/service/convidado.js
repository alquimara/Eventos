import{ http } from './config'

export default{
    getConvidados:(id)=>{
        return http.get('convidados/' + id)
      },
      createConvidado:(convidado, id)=>{
        return http.post('cadastrarconvidado/' + id, convidado)
    
      },
      updateConvidado:(convidado)=>{
        return http.put('atualizarconvidado', convidado)
      },
      deleteConvidado:(convidado)=>{
        return http.delete('/excluirconvidado', {data:convidado})
    
      },
      buscarConvidado:(nomepesquisa)=>{
        return http.get('/pesquisarconvidado', {params:{nomepesquisa}})
      }
}