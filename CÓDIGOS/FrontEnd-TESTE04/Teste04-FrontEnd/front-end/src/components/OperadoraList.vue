<template>
  <div class="operadora-list">
    <div v-if="loading" class="loading">Carregando...</div>
    
    <div v-else-if="operadoras.length === 0" class="empty-message">
      Nenhuma operadora encontrada
    </div>
    
    <div v-else class="operadora-items">
      <div v-for="operadora in operadoras" :key="operadora.id" class="operadora-item">
        <h3>{{ operadora.nome || operadora.razaoSocial }}</h3> <!-- Compatível com ambos os nomes -->
        <div class="operadora-details">
          <p><strong>CNPJ:</strong> {{ formatCnpj(operadora.cnpj) }}</p>
          <p><strong>Registro ANS:</strong> {{ operadora.registroANS }}</p>
          <p><strong>Localização:</strong> {{ operadora.cidade }}/{{ operadora.uf }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { formatCNPJ } from '@/utils/formatters';

export default {
  props: {
    operadoras: {
      type: Array,
      default: () => []
    },
    loading: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    formatCnpj(cnpj) {
      return formatCNPJ(cnpj); // Use a função centralizada
    }
  }
};
</script>

<style scoped>
.operadora-list {
  margin-top: 20px;
}

.loading, .empty-message {
  text-align: center;
  padding: 20px;
  color: #666;
}

.operadora-items {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 15px;
}

.operadora-item {
  background: #f8f9fa;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  padding: 15px;
  transition: transform 0.2s;
}

.operadora-item:hover {
  transform: translateY(-3px);
  box-shadow: 0 4px 8px rgba(0,0,0,0.1);
}

.operadora-item h3 {
  margin-top: 0;
  color: #2c3e50;
  border-bottom: 1px solid #eee;
  padding-bottom: 10px;
}

.operadora-details p {
  margin: 8px 0;
  color: #555;
}

.operadora-details strong {
  color: #333;
  display: inline-block;
  min-width: 100px;
}
</style>