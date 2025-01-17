import fetchWrapper from './fetchWrapper';

// Recupera tutti i documenti
export const getAllDocumenti = async () => {
  return await fetchWrapper('/Documenti');
};

// Recupera un documento per ID
export const getDocumentoById = async (id) => {
  return await fetchWrapper(`/Documenti/${id}`);
};

// Crea un nuovo documento
export const createDocumento = async (documento) => {
  return await fetchWrapper('/Documenti', {
    method: 'POST',
    body: JSON.stringify(documento),
  });
};

// Aggiorna un documento esistente
export const updateDocumento = async (id, documento) => {
  return await fetchWrapper(`/Documenti/${id}`, {
    method: 'PUT',
    body: JSON.stringify(documento),
  });
};

// Elimina un documento
export const deleteDocumento = async (id) => {
  return await fetchWrapper(`/Documenti/${id}`, {
    method: 'DELETE',
  });
};
