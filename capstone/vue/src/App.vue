<template>
  <div id="app">
    <div class="header">
      <div class="header-bar">
        <nav class="top-nav">
          <router-link id="links" class="links1" v-bind:to="{ name: 'home' }"
            >Home</router-link
          >
          <router-link id="links" class="links2" v-bind:to="{ name: 'account' }"
            >Dashboard</router-link
          >
          <router-link id="links" class="links3" v-bind:to="{ name: 'books' }"
            >Books</router-link
          >
          <router-link
            id="links"
            class="links4"
            v-bind:to="{ name: 'activity' }"
            >Reading Activity</router-link
          >
          
          <router-link
            id="links"
            class="links5"
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >

          <router-link v-else id="links" class="links6" v-bind:to="{ name: 'login' }"
            >Login</router-link
          >
        </nav>
        <div class="title-link">
        <router-link class="img-link" v-bind:to="{ name: 'home' }">
        <h4 class="title">Readitt.</h4>
        </router-link>
        </div>
      </div>
     
    </div>
    <div id="container">
      <router-view />
    </div>
  </div>
</template>

<style>
body {
  font-family: 'Source Sans Pro', sans-serif;
  font-family: mer;
  font-weight: bolder;
  font-size: 12px;
}
#app {
  display: flex;
  flex-direction: column;
  min-width: 450px;
  margin: auto;
  max-width: 1500;
}




.header {
  background-color: rgb(214, 205, 205);
  position: fixed;
  width: 100%;
  height: 60px;
  margin: -2px;
  border-top: 10px solid black;
  z-index: 1000;
}

.header-bar {
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 0px;
  padding-left: 5px;
  padding-right: 5px;
  height: 30px;
  margin-right: 10px;
  margin-top:5px;
}

.top-nav {
  display: flex;
  justify-content: space-between;
  width: 800px;
  padding-bottom: 5px;
  color: rgb(52, 45, 146);
  margin-right: 10px;
  margin-left: 10px;
}

.title {
  font-weight: 900;
  color: rgb(28, 95, 196);
  font-size: 28px;
 text-shadow: 2px 2px 2px gray;
  margin-left: 20px;
  font-family: 'Lora', serif;
  
}

.book-cover {
  width: 25px;
  height: 35px;
  padding-left: 5px;
  box-shadow: 5px 5px 3px rgb(127, 131, 133);
  border-radius: 3px;
  margin-left:5px;
}

#links {
  display: flex;
  justify-content: center;
  padding-top: 20px;
  text-decoration: none;
  font-size: 16px;
  font-weight: 700;
  padding-bottom: 10px;
  text-shadow: 1px 1px 3px gray;
}
.links1 {
  color: rgb(28, 95, 196);
}

.links1:hover {
  color: #c71a1a;
  text-shadow: 1px 1px black;
}

.links2 {
  color: rgb(28, 95, 196);
}
.links2:hover {
  color: #358a3c;
  text-shadow: 3px 3px 3px gray;
}

.links3 {
  color: rgb(28, 95, 196);}
.links3:hover {
  color: #3537cc;
  text-shadow: 3px 3px 3px gray
}

.links4 {
  color: rgb(28, 95, 196);}
.links4:hover {
  color: #e77e1b;
  text-shadow: 3px 3px 3px gray
}

.links5 {
  color: rgb(28, 95, 196);}
.links5:hover {
  color: rgb(155, 13, 155);
  text-shadow: 3px 3px 3px gray
}

.links6 {
  color: rgb(28, 95, 196);}
.links6:hover {
  color: rgb(155, 13, 155);
  text-shadow: 3px 3px 3px gray
}

.img-link {
  text-decoration: none;
}

.title-link{
  margin-left:40px;
}

body::-webkit-scrollbar {
  width: 8px;               /* width of the entire scrollbar */
}

body::-webkit-scrollbar-thumb {
  background-color: rgb(159, 159, 173);    /* color of the scroll thumb */
  border-radius: 20px;       /* roundness of the scroll thumb */
}
body::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px grey;
  border-radius: 10px;
}

</style>
