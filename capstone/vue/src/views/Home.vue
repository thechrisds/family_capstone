<template>
  <div class="home">
    <div class="home-title-box">
        <h1 class="home-title"><a href="#app-info-box" class="home-page-link">READITT.</a></h1>
        <p class="sub-title">A family that reads together, stays together</p>
    </div>
    <div id="app-info-box">
      <h3>How it works</h3>
      <p>Parents and children can view our user curated library and add books to their own!</p>
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
  margin-top:100px;
  background-color:white;
  background-image: url('../assets/books.jpg');
  height:5000px;
  background-attachment: fixed;
  background-position: center;
  background-repeat: no-repeat;
  background-size: 100%;;
  width:100%;
  justify-content:center;

}
.home-title-box{
  background-color: white;
  width:100%;
  margin-top:150px;
}
.home-title {
  font-weight: 900;
  color: rgb(128, 212, 240);
  font-size: 80px;
  text-shadow: 3px 3px rgb(192, 230, 243);
  text-align: center;
}
.sub-title {
  font-family: 'Poppins', sans-serif;
  text-align: center;
  font-size: 25px;
}
#app-info-box{
  background-color: white;
  margin-top:50px;
}

.home-page-link{
  text-decoration: none;
  color: rgb(128, 212, 240);
}



</style>
