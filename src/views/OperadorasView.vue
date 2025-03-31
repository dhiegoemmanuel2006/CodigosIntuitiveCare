<template>
    <div class="operadoras-view">
      <h1>Consulta baseada no Nome Fantasia ou Razão Social</h1>
      
      <SearchBox 
        @search-complete="operadoras = $event"
        @search-error="handleError"
      />
      
      <OperadoraList
        :operadoras="operadoras"
        :loading="loading"
      />
    </div>
  </template>
  
  <script>
  import SearchBox from '@/components/SearchBox.vue';
  import OperadoraList from '@/components/OperadoraList.vue';
  
  export default {
    components: { SearchBox, OperadoraList },
    data() {
      return {
        operadoras: [],
        loading: false
      };
    },
    methods: {
      handleError(error) {
        console.error("Erro na busca:", error);
        this.operadoras = [];
        alert("Ocorreu um erro na busca. Por favor, tente novamente.");
      }
    }
  };
  </script>
  
  <style scoped>
  .operadoras-view {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
  }
  </style>