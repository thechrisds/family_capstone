<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style>
.home {
display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  justify-content: space-evenly;
  max-width: 1800px;
}
</style>
