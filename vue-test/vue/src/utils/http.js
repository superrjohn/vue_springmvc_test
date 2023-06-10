//axios封裝
import { useUserStore } from '../stores/user'

import axios from  'axios'

const request = axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 5000,
    //withCredentials: true
})
//攔截器

request.interceptors.request.use(config => {
    const useStore = useUserStore()
 
    const data = useStore.userInfo.data
    if(data){
        config.headers.token = `Bearer ${data}`
    }
    return config
}),e => Promise.reject(e)

//request.interceptors.response.use(res => {})

export default request