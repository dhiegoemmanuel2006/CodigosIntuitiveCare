import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080',
  timeout: 5000
});

api.interceptors.request.use(config => {
  console.log('Enviando requisição para:', config.url);
  return config;
});

api.interceptors.response.use(
  response => {
    console.log('Resposta recebida:', response);
    return response;
  },
  error => {
    console.error('Erro na requisição:', {
      url: error.config.url,
      status: error.response?.status,
      data: error.response?.data
    });
    return Promise.reject(error);
  }
);

export const OperadorasService = {
  buscarOperadoras: (termoBusca) => {
    const termoTratado = encodeURIComponent(termoBusca.trim());
    return api.get(`/mais-relevantes-operadoras/${termoTratado}`)
      .then(response => {
        if (!response.data || response.data.length === 0) {
          throw new Error('Nenhum resultado encontrado');
        }
        return response;
      });
  }
};