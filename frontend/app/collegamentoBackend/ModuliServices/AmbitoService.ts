import fetchWrapper from '../fetchWrapper';

interface Ambito {
  // Definisci qui le proprietà dell'interfaccia Ambito
  id?: number;
  nome: string;
  descrizione?: string;
}

// Recupera tutti gli ambiti
export const getAllAmbiti = async (): Promise<Ambito[]> => {
  return await fetchWrapper('/AmbitiController') as Ambito[];
};

// Recupera un ambito per ID
export const getAmbitoById = async (id: number): Promise<Ambito> => {
  return await fetchWrapper(`/AmbitiController/${id}`) as Ambito;
};

// Crea un nuovo ambito
export const createAmbito = async (ambito: Ambito): Promise<Ambito> => {
  return await fetchWrapper('/AmbitiController', {
    method: 'POST',
    body: JSON.stringify(ambito),
  }) as Ambito;
};

// Aggiorna un ambito esistente
export const updateAmbito = async (id: number, ambito: Ambito): Promise<Ambito> => {
  return await fetchWrapper(`/AmbitiController/${id}`, {
    method: 'PUT',
    body: JSON.stringify(ambito),
  }) as Ambito;
};

// Elimina un ambito
export const deleteAmbito = async (id: number): Promise<void> => {
  await fetchWrapper(`/AmbitiController/${id}`, {
    method: 'DELETE',
  });
};