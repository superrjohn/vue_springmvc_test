import { loginAPI } from "@/apis/user";
import { defineStore } from "pinia";

export const useUserStore = defineStore('user', {
    state: () => ({
        userInfo: {}
    }),
    actions: {
        async getUserInfo({ username, password}) {
            const res = await loginAPI({ username, password })
            this.userInfo = res.data
        },
        clearUserInfo() {
            this.userInfo = { }
        }
    },
    persist: true
})