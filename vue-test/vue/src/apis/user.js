//封裝用戶相關接口
import request from "@/utils/http"

export const loginAPI = ({ username, password }) => {
    return request({
        url: 'login',
        method: 'POST',
        data: {
            username,
            password
        }
    })
}