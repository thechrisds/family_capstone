<template>
  <div class="home">
    
    <div id="box-1" class="home-title-box">
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

      <div class="how-it-works-container">

        <div class="library-card">
          <h3 class="library-title" align="center">Choose some books!</h3>
          <p class="library-p" align="center">
            Choose any of our family recommended books to add to your own family
            library. Our library is comprised of books chosen by our families!
          </p>
          <img src="@/assets/bookexample2.png" class="library-img" />
        </div>

        <div class="record-activities-container">
          <div class="record-card">
            <h3 class="record-title" align="center">Record your reading!</h3>
            <p class="record-p" align="center">
              Sit, relax, read! When you're done, log those minutes.
            </p>
          </div>
          <div class="minutes-div">
            <img src="@/assets/minutes.png" class="minutes-img" />
          </div>
        </div>

        <div class="prizes-container">
          <div class="prizes-info">
            <h3 class="prizes-title" align="center">Win Prizes!</h3>
            <p class="record-p" align="center">
              As you log more minutes, earn more prizes!
            </p>
          </div>
          <div class="prizesimg-div">
            <img src="@/assets/prizefinal1.png" class="prizes-img" />
          </div>
        </div>

        <div class="dash-card">
          <h3 class="dash-title" align="center">Keep track with your family dashboard!</h3>
          <p class="dash-p" align="center">
            Personalized dashboard with all family members, your family library, prizes, and more!
          </p>
          <img src="@/assets/dashboard.png" class="dash-img" />
        </div>
      </div>
    </div>

    <div id="box-3">
      <h1 class="home-title">
        <br /><br /><br />
        <a href="#box-4" class="link-style">Get started today!</a>
      </h1>
      <p class="sub-title2"> <router-link id="register-or-login" class="links1" v-bind:to="{ name: 'login' }"
            >Register | Login</router-link
          ></p>
    </div>

    <div id="box-4">
      <h1 class="home-title">
        <br /><br /><br />
        <a href="#box-1" class="link-style">Team Members</a>
      </h1>
      
      <div class="members">
        <img src="@/assets/team.jpg" class="team-pic">
        <h2>James Cagle | Chris Schriver | Daniel Song</h2>
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
  height: 100px;
  margin-top: 200px;
  padding-bottom:50px;
  text-align:initial;
}
.home-title {
  font-weight: 900;
  color: rgb(19, 57, 70);
  font-size: 50px;
  text-shadow: 3px 3px rgb(175, 154, 125);
  text-align: center;
}

.link-style {
  text-decoration: none;
  color: rgb(104, 32, 32);
}

.sub-title {
  font-family: "Poppins", sans-serif;
  text-align: center;
  font-size: 25px;
}

.sub-title2 {
  text-align: center;
}

#register-or-login {
  font-size: 30px;
  text-decoration: none;
  font-weight: 600;
}

#box-1 {
  background-color: white;
  margin-top: 150px;
}

#box-2 {
  background-color: white;
  margin-top: 750px;
}

.how-it-works-container {
  display: flex;
  justify-content: space-evenly;
  align-content: center;
  flex-wrap: wrap;
}

.library-card {
  border: solid 2px lightgray;
  border-radius: 10px;
  margin-bottom: 30px;
  margin-left: 40px;
  padding: 20px;
  height: 250px;
  width: 350px;
}

.library-text {
  border: solid 2px lightgray;
  border-radius: 10px;
  margin-bottom: 30px;
  margin-left: 40px;
  padding: 20px;
  height: 175px;
  width: 300px;
}

.library-img {
  width: 350px;
  height: auto;

}

.record-activities-container {
  display: flex;
  justify-content: space-between;
  align-content: center;
  flex-direction: row;
  flex-wrap: wrap;
  border: solid 2px lightgray;
  border-radius: 10px;
  margin-bottom: 30px;
  margin-left: 40px;
  padding: 20px;
  height: 250px;
  width: 350px;
}

.record-card {
  width: 100px;
}

.minutes-img {
  width: 150px;
  height: auto;
  
}

.minutes-img:hover {
  animation: shake 0.5s;
  animation-iteration-count: infinite;
}


@keyframes shake {
  0% { transform: translate(1px, 1px) rotate(0deg); }
  10% { transform: translate(-1px, -2px) rotate(-1deg); }
  20% { transform: translate(-3px, 0px) rotate(1deg); }
  30% { transform: translate(3px, 2px) rotate(0deg); }
  40% { transform: translate(1px, -1px) rotate(1deg); }
  50% { transform: translate(-1px, 2px) rotate(-1deg); }
  60% { transform: translate(-3px, 1px) rotate(0deg); }
  70% { transform: translate(3px, 1px) rotate(-1deg); }
  80% { transform: translate(-1px, -1px) rotate(1deg); }
  90% { transform: translate(1px, 2px) rotate(0deg); }
  100% { transform: translate(1px, -2px) rotate(-1deg); }
}

.prizes-container {
  display: flex;
  justify-content: space-between;
  align-content: center;
  flex-direction: row;
  flex-wrap: wrap;
  border: solid 2px lightgray;
  border-radius: 10px;
  margin-bottom: 30px;
  margin-left: 40px;
  padding: 20px;
  height: 250px;
  width: 350px;
}

.prizes-info {
  width: 100px;
  height:auto;
}

.prizes-img {
  width:250px;
}

.dash-card {
  border: solid 2px lightgray;
  border-radius: 10px;
  margin-bottom: 30px;
  margin-left: 40px;
  padding: 20px;
  height: 250px;
  width: 350px;
}

.dash-img {
  width:350px;

}

#box-3 {
  background-color: white;
  margin-top: 1000px;
  padding-bottom: 30px;
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


.team-pic {
  width:400px;
  display: block;
  margin-left:auto;
  margin-right:auto;
}
</style>
