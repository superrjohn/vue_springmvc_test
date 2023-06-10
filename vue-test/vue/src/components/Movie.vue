<template>
  <div>
    {{ count }}
    <button @click="increment">++</button>
  </div>
</template>

<script >
//vue2用映射
import { mapState,mapActions } from "pinia";
import { useCounterStore } from "../stores/counter";

export default {
  computed: {
    // 可以访问组件中的 this.count
    // 与从 store.count 中读取的数据相同
    ...mapState(useCounterStore, ["count"])
  },
  methods: {
    // 访问组件内的 this.increment()
    // 与从 store.increment() 调用相同
    ...mapActions(useCounterStore, ["increment"])
  }
};
</script>

<style>
</style>