import fetchWrapper from "../fetchWrapper";

interface Documento {
  // Definisci qui le proprietà dell'interfaccia Documento
  id?: number;
  titolo: string;
  contenuto: string;
  dataCreazione?: string;
}

// Recupera tutti i documenti
export const getAllDocumenti = async (): Promise<Documento[]> => {
  return (await fetchWrapper("/Documenti")) as Documento[];
};

// Recupera un documento per ID
export const getDocumentoById = async (id: number): Promise<Documento> => {
  return (await fetchWrapper(`/Documenti/${id}`)) as Documento;
};

// Crea un nuovo documento
export const createDocumento = async (
  documento: Documento
): Promise<Documento> => {
  return (await fetchWrapper("/Documenti", {
    method: "POST",
    body: JSON.stringify(documento),
  })) as Documento;
};

// Aggiorna un documento esistente
export const updateDocumento = async (
  id: number,
  documento: Documento
): Promise<Documento> => {
  return (await fetchWrapper(`/Documenti/${id}`, {
    method: "PUT",
    body: JSON.stringify(documento),
  })) as Documento;
};

// Elimina un documento
export const deleteDocumento = async (id: number): Promise<void> => {
  await fetchWrapper(`/Documenti/${id}`, {
    method: "DELETE",
  });
};
