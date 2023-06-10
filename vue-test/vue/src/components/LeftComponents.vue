<template>
  <div class="row">
    <div class="col">
      <ul>
        <li class="text-primary border border-primary">{{ prodecs.id }}</li>
        <li class="border border-secondary">{{ prodecs.goods_name }}</li>
        <li class="border border-warning">{{ prodecs.goods_price }}</li>
        <slot></slot>
        <li class="border border-dark">{{ prodecs.tags }}</li>
      </ul>
    </div>
    
  </div>
</template>

<script>
export default {
  props: {
    prodecs: {
      type: Object
    }
  }
};
</script>

<style>
</style>