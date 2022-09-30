<template>
  <div class="home">
    <div class="home-title-box">
      <h1 class="home-title">
        <a href="#box-2" class="link-style">READITT.</a>
      </h1>
      <p class="sub-title">A family that reads together, stays together</p>
    </div>
    <div id="box-2">
      <br /><br /><br /><br /><br /><br /><br /><br />
      <h1 class="home-title">
        <a href="#box-3" class="link-style">How it works</a>
      </h1>
    </div>
    <div id="box-3">
      <br /><br /><br /><br /><br /><br /><br /><br />
      <h3 class="home-title">
        <a href="#box-4" class="link-style">Browse our library</a>
      </h3>
      <div class="box3-content">
        <div class="box3-text">
          <h3>
            Choose any of our family recommended books to add to your own family
            library. Our library is comprised of books chosen by our families!
          </h3>
        </div>
        <div class="box3-img-div">
          <img src="@/assets/bookexample2.png" class="box3-img" />
        </div>
      </div>
    </div>
    <div id="box-4">
      <br /><br /><br /><br /><br /><br /><br /><br />
      <h3 class="home-title">
        <a href="#box-5" class="link-style">Set Reading Activities</a>
      </h3>
      <div class="box4-content">
        <div class="box4-text">
          <h3>
            Choose any of our family recommended books to add to your own family
            library. Our library is comprised of books chosen by our families!
          </h3>
        </div>
        <div class="box3-img-div">
          <img src="@/assets/bookexample2.png" class="box3-img" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style>
.home {
  background-color: white;
  background-image: url("../assets/books.jpg");
  height: 10000px;
  background-attachment: fixed;
  background-position: center;
  background-repeat: no-repeat;
  margin-top: 150px;
}
.home-title-box {
  background-color: white;
  width: 100%;
  height: 250px;
  margin-top: 200px;
}
.home-title {
  font-weight: 900;
  color: rgb(128, 212, 240);
  font-size: 80px;
  text-shadow: 3px 3px rgb(192, 230, 243);
  text-align: center;
}
.sub-title {
  font-family: "Poppins", sans-serif;
  text-align: center;
  font-size: 25px;
}
#box-1 {
  background-color: white;
  margin-top: 1000px;
}

#box-2 {
  background-color: white;
  margin-top: 1000px;
}

#box-3 {
  background-color: white;
  margin-top: 1000px;
}
#box-4 {
  background-color: white;
  margin-top: 1000px;
}
.box3-content {
  display: flex;
  justify-content: space-between;
  align-content: center;
}

.box3-text {
  border: solid 2px lightgray;
  border-radius: 10px;
  margin-bottom: 30px;
  margin-left: 40px;
  padding: 20px;
  height: 175px;
  width: 300px;
}

.box3-img {
  width: 400px;
  height: auto;
}

.box3-img-div {
  border: solid 2px lightgray;
  border-radius: 10px;
  margin-bottom: 30px;
  margin-right: 40px;
  height: 175px;
}
.link-style {
  text-decoration: none;
  color: rgb(128, 212, 240);
}
</style>
