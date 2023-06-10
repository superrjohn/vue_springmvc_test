<template>
  <div>
    <router-link to="/about/tb1">tb1</router-link>
    <router-link to="/about/tb2">tb2</router-link>
    <router-view></router-view>
    {{userInfo}}
  </div>
</template>

<script>
import { loginAPI } from "@/apis/user";
import { mapState, mapActions } from "pinia";
import { useUserStore } from "../stores/user";

export default {
  created() {
    const { username, password } = this.postData;
    this.getUserInfo({username, password});
  },
  computed: {
    // 可以访问组件中的 this.count
    // 与从 store.count 中读取的数据相同
    ...mapState(useUserStore, ["userInfo"])
  },
  data() {
    return {
      postData: {
        username: "abcd123",
        password: "123456"
      }
    };
  },
  methods: {
    async login() {
      const { username, password } = this.postData;
      const res = await loginAPI({ username, password });
      console.log(res);
    },
    // 访问组件内的 this.increment()
    // 与从 store.increment() 调用相同
    ...mapActions(useUserStore, ["getUserInfo"])
  }
};
</script>

<style>
</style>