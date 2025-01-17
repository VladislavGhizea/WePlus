import fetchWrapper from './fetchWrapper';

// Recupera tutte le entità individuali
export const getAllEntitaIndividuali = async () => {
  return await fetchWrapper('/EntitaIndividuali');
};

// Recupera un'entità individuale per ID
export const getEntitaIndividualeById = async (id) => {
  return await fetchWrapper(`/EntitaIndividuali/${id}`);
};

// Crea una nuova entità individuale
export const createEntitaIndividuale = async (entita) => {
  return await fetchWrapper('/EntitaIndividuali', {
    method: 'POST',
    body: JSON.stringify(entita),
  });
};

// Aggiorna un'entità individuale esistente
export const updateEntitaIndividuale = async (id, entita) => {
  return await fetchWrapper(`/EntitaIndividuali/${id}`, {
    method: 'PUT',
    body: JSON.stringify(entita),
  });
};

// Elimina un'entità individuale
export const deleteEntitaIndividuale = async (id) => {
  return await fetchWrapper(`/EntitaIndividuali/${id}`, {
    method: 'DELETE',
  });
};
