
<template>
    <div>
        <div class="bookList" v-for="book in books" v-bind:key="book.bookID" v-bind:book="book">
            Test
        </div>
        
     
    </div>
</template>

<script>
import bookService from '@/services/BookService.js';
export default{
    props: ["book"],
    name: 'view-book',
    data(){
        return {
            books: []
        };
    },
    created() {
        bookService.seeBooks().then( response => {
            this.books = response.data;
            }).catch 
        }
    };
</script>

<style scoped>

</style>