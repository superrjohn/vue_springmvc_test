<template>
  <div>
    +
  </div>
</template>


<script>
import {getHome} from '../apis/testApi'

export default {
  created() {
    this.home()
  },
  data() {
    return {
      message: {}
    };
  },
  methods: {
    home(){
     getHome().then(res => console.log(res))
    }
  }
};
</script>

<style>
</style>