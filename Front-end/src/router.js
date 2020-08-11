import Vue from 'vue';
import Router from 'vue-router';
import cadastro from './componentes/cadastro.vue'
import home from './componentes/home.vue'
import convidado from './componentes/convidado.vue'
import cadastroConvidado from './componentes/cadastroConvidado.vue'
import usuario from './componentes/cadastroUsuario.vue'
import login from './componentes/login.vue'

Vue.use(Router)


export default new Router(
    {
        routes:[
            {
                mode: "history",
                path: "/",
                component: home

            },
            {
                path: "/cadastro",
                component: cadastro
            },
            {
                path: "/convidado",
                component: convidado
            },
            {
                path: "/cadastroconvidado",
                component: cadastroConvidado
            },
            {
                path:"/cadastrousuario",
                component: usuario
            },
            {
                path:"/login",
                component: login
            }

        ]
    }
)