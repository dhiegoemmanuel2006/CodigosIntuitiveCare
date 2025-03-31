export const formatCNPJ = (cnpj) => {
    if (!cnpj) return 'Não informado';
    
    
    const cleaned = cnpj.toString().replace(/\D/g, '');
    
    if (cleaned.length !== 14) return cnpj;
    

    return cleaned.replace(
      /^(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})$/,
      '$1.$2.$3/$4-$5'
    );
  };