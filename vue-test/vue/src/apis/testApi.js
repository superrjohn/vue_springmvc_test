import request from '../utils/http'

export function getHome(){
    return request({
        method: 'get',
        url: 'home'
    })
}

