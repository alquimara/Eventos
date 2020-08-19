import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
    state:{
        evento: {
            id: "",
            nome: "",
            endereco: "",
            cidade:"",
            datae: "",
            horario:""
        },
        eventos:[],
        convidado:{
            nome: "",
            email: "",
            rg: ""
        },
        usuario:{
            id: "",
            email: "",
            nome: "",
            senha:""

        },
        convidados:[],
        usuarios:[]
    }
});