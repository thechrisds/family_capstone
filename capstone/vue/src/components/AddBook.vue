<template>
    <div>

    </div>
</template>

<script>
import bookService from '@/services/BookService.js';
export default({
    name: 'add-book',
    components: {},
    data(){
        return {
            books: []
        }
    },
    methods: {
        getBooks(){
            bookService.seeBooks().then( (response)=> {
                this.books = response.data;
            })
        }
    }
})
</script>

<style scoped>

</style>