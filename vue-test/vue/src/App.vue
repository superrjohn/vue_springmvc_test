<template>
  <div>
    <div class="container">
      <left-components v-for="item in list" :key="item.id" :prodecs="item">
        <p>{{item.goods_name}}</p>
      </left-components>
    </div>
  </div>
</template>

<script>
import LeftComponents from "./components/LeftComponents.vue";
//import axios from "axios";

export default {
  created() {
    this.list = this.initCartList();
  },
  components: { LeftComponents },
  data() {
    return {
      message: "App",
      total: 3,
      list: []
    };
  },
  methods: {
    getName(val) {
      this.message = val;
      this.$refs.et.style.color = "red";
    },
    show() {
      this.$refs.left.showConsole();
    },
    async initCartList() {
      await this.axios
        .get("https://applet-base-api-t.itheima.net/api/goods")
        .then(res => {
          this.list = res.data.data;
          console.log(this.list);
        });
    }
  }
};
</script>

<style scoped>
</style>