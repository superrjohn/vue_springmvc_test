<template>
  <div>
    <button @click="clearUserInfo">登出</button>
  </div>
</template>

<script>
import { mapState, mapActions } from "pinia";
import { useUserStore } from "../../stores/user";

export default {
  computed: {
    // 可以访问组件中的 this.count
    // 与从 store.count 中读取的数据相同
    ...mapState(useUserStore, ["userInfo"])
  },
  methods: {
    ...mapActions(useUserStore, ["clearUserInfo"])
  }
};
</script>

<style>
</style>