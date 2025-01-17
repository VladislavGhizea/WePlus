import fetchWrapper from './fetchWrapper';

// Recupera tutti gli ambiti
export const getAllAmbiti = async () => {
  return await fetchWrapper('/AmbitiController');
};

// Recupera un ambito per ID
export const getAmbitoById = async (id) => {
  return await fetchWrapper(`/AmbitiController/${id}`);
};

// Crea un nuovo ambito
export const createAmbito = async (ambito) => {
  return await fetchWrapper('/AmbitiController', {
    method: 'POST',
    body: JSON.stringify(ambito),
  });
};

// Aggiorna un ambito esistente
export const updateAmbito = async (id, ambito) => {
  return await fetchWrapper(`/AmbitiController/${id}`, {
    method: 'PUT',
    body: JSON.stringify(ambito),
  });
};

// Elimina un ambito
export const deleteAmbito = async (id) => {
  return await fetchWrapper(`/AmbitiController/${id}`, {
    method: 'DELETE',
  });
};
