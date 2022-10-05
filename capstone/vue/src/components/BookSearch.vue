<template>
    <div class="search-container">

        <b-form class="search-form">
        <b-form-input placeholder="Search" v-model="word"/>
        <b-button @click="search"> Search </b-button>
        </b-form>

        <div class="tb-bookList" v-for="book in books" v-bind:key="book.bookID" v-bind:book="book" @click="()=>{setbook(book)}" @mouseover="hover = true">
            <div class="wrapper" >
<div class="book">
  <div class="inner-book">
    <div class="img" style="padding-top: calc(1.07 * 100%)">
      <img
        v-if="book.isbn"
        v-bind:src="
          'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-L.jpg'
        "
      />
    </div>
    <div class="page"></div>
    <div class="page page-2"></div>
    <div class="page page-3"></div>
    <div class="page page-4"></div>
    <div class="page page-5"></div>
    <div class="img final-page" style="padding-top: calc(1.07 * 100%)">
      <img
        v-if="book.isbn"
        v-bind:src="
          'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-L.jpg'
        "
      />
    </div>
  </div>
</div>
</div>
            <h2 class="tb-book-title">{{book.title}}</h2>
            <h3 class="tb-book-author">{{ book.author_name }}</h3>
        </div>
    </div>
</template>


<script>
import bookService from '@/services/BookService.js';
import axios from 'axios'
export default{
    name: "book-search",
    data(){
        return {
            book: [],
            word: "",
            books: []

        }
    },
    methods: {
        emptyForm(){
            this.word = "";
        },
        search(){
            bookService.googleBook(this.word).then(response =>{
              axios.defaults.headers.common['Authorization'] = 'null'
                this.books = response.data.docs;
                
                console.log(response);
            })
        }
        
    }
    
}
</script>


<style scoped>
#cover{
  height: 300px;
  width: 200px;
}

.wrapper {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  padding-right: 20px;
}

.inner-book {
  width: 60vh;
}

.book {
    padding-bottom: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  transform: translateZ(0);
}

.inner-book {
  display: flex;
  align-items: center;
  transform-style: preserve-3d;
  perspective: 2000px;
}

.inner-book {
    width: 235px;
    height: 300px;
  display: flex;
  align-items: center;
  transform-style: preserve-3d;
  perspective: 2000px;
}

.inner-book:before {
  content: "";
  width: 100%;
  position: absolute;
  height: 0;
  bottom: 14px;
  transform: rotateY(-20deg) translateZ(-20px);
  z-index: 0;
  box-shadow: 10px 12px 20px 13px rgba(0, 0, 0, 0.3);
}

.inner-book .img {
  transform: rotateY(-20deg);
  width: 100%;
  z-index: 5;
  clear: both;
  height: 100%;
  background: #ddd;
}

.inner-book img {
  width: 100%;
  height: 100%;
  display: block;
  position: absolute;
  top: 0;
}

.inner-book .img:before {
  content: "";
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  border: 2px solid rgba(0, 0, 0, 0.2);
  box-sizing: border-box;
  border-left: 4px solid rgba(0, 0, 0, 0.3);
  z-index: 2;
}

.page {
  width: calc(100% - 20px);
  height: calc(100% - 2px);
  position: absolute;
  box-shadow: inset 0px -1px 2px rgba(50, 50, 50, 0.2),
    inset -1px 0px 1px rgba(150, 150, 150, 0.1);
  border-radius: 0px 3px 3px 0px;
  transform: rotateY(-20deg) translateZ(-5px);
  right: -3px;
  z-index: 4;
  background: white;
}

.page-2 {
  height: calc(100% - 4px);
  right: -6px;
  z-index: 3;
}

.page-3 {
  height: calc(100% - 6px);
  right: -9px;
  z-index: 2;
}

.page-4 {
  height: calc(100% - 8px);
  right: -12px;
  z-index: 1;
}

.page-5 {
  height: calc(100% - 10px);
  right: -15px;
  z-index: 0;
}

.img.final-page {
  position: absolute;
  z-index: -1;
  right: -17px;
  transform: rotateY(-19deg) translateZ(-10px) scale(0.984);
}

.tb-container {
    margin-top: 200px;
    display:flex;
    flex-wrap:wrap;
    justify-content: space-evenly;
    align-content:center;
    

}

.tb-bookList {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    width: 250px;
    height: 350px;
    margin: 20px;
    text-align:center;
    
    
}
.tb-bookList {
  cursor:pointer;
  pointer-events:inherit;
  vertical-align: middle;
  -webkit-transform: perspective(1px) translateZ(0);
  transform: perspective(1px) translateZ(0);
  box-shadow: 0 0 1px rgba(0, 0, 0, 0);
  -webkit-transition-duration: 0.3s;
  transition-duration: 0.3s;
  -webkit-transition-property: transform;
  transition-property: transform;
}
.tb-bookList:hover, .tb-bookList:focus, .tb-bookList:active {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}

.tb-bookList.read {
    
}

.tb-bookList .tb-book-title {
    word-wrap: break-word;
    text-overflow: ellipsis;
    font-size: 20px;
    margin-left:5px;
    margin-right:5px;
    
    
}
.tb-bookList .tb-book-author {
    font-size: 14px;
    
}
.tb-bookList > img{
    height: auto;
    width: 235px;
    height: 250px;
    align-self: center;
}

.tb-book-description {
    word-wrap: break-word;
    padding:5px;
    font-size: 14px;
    
}

.tb-description {
    overflow-x:hidden;
    overflow-y:auto;
    height: 50px;
    border: 1px solid lightgoldenrodyellow;
    box-shadow: 1px 1px 3px lightgoldenrodyellow;
    margin-bottom: 10px;
    margin-top: -5px;
}

</style>
