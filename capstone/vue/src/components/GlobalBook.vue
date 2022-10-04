<template>
    <div class="vb-container">
        <div class="vb-bookList" v-for="book in books" v-bind:key="book.bookID" v-bind:book="book">
            <h2 class="vb-book-title">{{book.bookTitle}}</h2>
            <h3 class="vb-book-author">{{ book.bookAuthor }}</h3>
            <img class="vb-img" v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
            <div class="vb-description">
            <p class="vb-book-description">{{ book.description }}</p>
            <p class="vb-null-description" v-if="!book.description"> No description given</p>
            </div>
        </div>
        
     
    </div>
</template>

<script>
import bookService from '@/services/BookService.js';
export default{
    name: 'view-book',
    data(){
        return {
            books: []
        };
    },
    created() {
        bookService.seeOpenBooks().then( response => {
            this.books = response.data;
            }).catch 
        }
    };
</script>

<style>
.vb-container {
    display:flex;
    flex-wrap:wrap;
    justify-content: space-evenly;
    align-content:center;

}
.vb-bookList {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    width: 250px;
    height: 350px;
    margin: 20px;
    text-align:center;
    background-color:white;
     border-top: 10px rgb(207, 193, 0) solid;
  border-right: 10px goldenrod solid;
  border-bottom: 10px solid rgb(175, 133, 25);
  border-left: 10px solid rgb(255, 233, 107);
  box-shadow: 5px 5px 15px rgb(155, 132, 3);
  font-family: 'Lora', serif;
}

.vb-bookList.read {
    background-color: lightgray;
}

.vb-bookList .vb-book-title {
    word-wrap: break-word;
    text-overflow: ellipsis;
    font-size: 25px;
    margin-left:5px;
    margin-right:5px;
    
}

.vb-bookList .vb-book-author {
    font-size: 14px;
}
.vb-bookList > img{
    height: auto;
    width: 75%;
    align-self: center;
}

.vb-book-description {
    word-wrap: break-word;
    padding:5px;
    font-size: 14px;
    
}

.vb-description {
    overflow-x:hidden;
    overflow-y:auto;
    height: 50px;
    border: 1px solid lightgoldenrodyellow;
    box-shadow: 1px 1px 3px lightgoldenrodyellow;
    margin-bottom: 10px;
    margin-top: -5px;
}

</style>