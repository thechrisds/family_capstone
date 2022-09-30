<template>
  <div class="home">
    <div class="home-body">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    </div>
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
  background-color:white;
  background-image: url('../assets/books.jpg');
  height:1200px;
  background-attachment: fixed;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
.home-body{
  display:flex;
  align-items: flex-start;
  background-color: white;
  opacity: .7;
}


</style>
