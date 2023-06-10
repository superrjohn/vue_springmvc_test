import Vue from 'vue'
import VueRouter from 'vue-router'
import App from '../App.vue'
import Home from '../components/Home.vue'
import About from '../components/About.vue'
import Tb1 from '../components/tb/Tb1.vue'
import Tb2 from '../components/tb/Tb2.vue'
import Movie from '../components/Movie.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '',
    component: Home
  },
  {
    path: '/home',
    component: Home
  },
  {
    path: '/app',
    component: App
  },
  {
    path: '/about',
    component: About,
    redirect: '/about/tb1',
    children: [
      { path: 'tb1', component: Tb1 },
      { path: 'tb2', component: Tb2 }
    ]
  },
  {
    path: '/movie/:id',
    component: Movie,
    props: true
  }
]

const router = new VueRouter({
  routes
})

export default router
