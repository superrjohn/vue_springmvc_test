import Vue from 'vue'
import App from './App2.vue'
import router from './router'
import axios from 'axios'
import { createPinia, PiniaVuePlugin } from 'pinia'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'

Vue.use(PiniaVuePlugin)
const pinia = createPinia()
pinia.use(piniaPluginPersistedstate)

Vue.config.productionTip = false

import MyCount from './components/MyCount.vue'
Vue.component('MyCount', MyCount)

Vue.prototype.axios = axios


new Vue({
  router,
  pinia,
  render: h => h(App),
}).$mount('#app')
