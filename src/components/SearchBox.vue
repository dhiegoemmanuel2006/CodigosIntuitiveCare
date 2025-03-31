<template>
  <div class="search-box">
    <input
      type="text"
      v-model="searchTerm"
      @keyup.enter="handleSearch"
      placeholder="Digite razão social ou CNPJ..."
    />
    <button @click="handleSearch" :disabled="loading">
      {{ loading ? 'Buscando...' : 'Buscar' }}
    </button>
  </div>
</template>

<script>
import { OperadorasService } from '@/services/api';
export default {
  data() {
    return {
      searchTerm: '',
      loading: false
    };
  },
 
  methods: {
  async handleSearch() {
    if (!this.searchTerm.trim()) {
      alert('Por favor, digite um termo de busca');
      return;
    }

    this.loading = true;
    try {
      const response = await OperadorasService.buscarOperadoras(this.searchTerm);
      this.$emit('search-complete', response.data);
    } catch (error) {
      if (error.message === 'Nenhum resultado encontrado') {
        this.$emit('search-complete', []); // Envia array vazio para limpar resultados
        alert('Nenhuma operadora encontrada com este termo');
      } else {
        console.error('Erro detalhado:', error);
        alert(`Erro na busca: ${error.response?.data?.message || error.message}`);
      }
    } finally {
      this.loading = false;
    }
  }
}
};
</script>

<style scoped>
.search-box {
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
}

.search-box input {
  flex: 1;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.search-box button {
  padding: 10px 15px;
  background: #42b983;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.search-box button:disabled {
  background: #ccc;
  cursor: not-allowed;
}
</style>