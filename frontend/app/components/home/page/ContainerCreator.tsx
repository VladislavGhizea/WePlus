// import React, { useEffect, useState } from "react";
// import { Individuale, Giuridica, Fisica } from "@/app/variables";
import Container from "./Container";

// interface Props {
//   tipo: "FISICA" | "GIURIDICA" | "INDIVIDUALE" | "ADMIN";
// }
// interface BaseUser {
//   utenteGeneraleId: string;
// }

// interface FisicaUser extends BaseUser {
//   nome: string;
//   cognome: string;
//   cf: string;
//   sesso: string;
//   genere: string;
//   comuneDiN: string;
//   dataDiN: string;
//   indirizzoFisicaId: string;
// }

// interface GiuridicaUser extends BaseUser {
//   partitaIva: string;
//   tipo: string;
//   ragioneSociale: string;
// }

//interface IndividualeUser extends FisicaUser, GiuridicaUser {}

//type User = FisicaUser | GiuridicaUser | IndividualeUser;

//const getAllUsers = async (tipo: string): Promise<object[]> => {
//   let urls: string[] = [];
//   switch (tipo) {
//     case "FISICA":
//       urls = ["/personeGiuridiche", "/entitaIndividuali"];
//       break;
//     case "GIURIDICA":
//       urls = ["/personeFisiche", "/entitaIndividuali"];
//       break;
//     case "INDIVIDUALE":
//       urls = ["/personeFisiche", "/personeGiuridiche"];
//       break;
//     case "ADMIN":
//       throw new Error("NON IMPLEMENTATO"); 
//     default:
//       throw new Error("Tipo di utente non valido");
//   }

//   try {
//     const responses = await Promise.all(urls.map(url => fetch(url)));
//     const data = await Promise.all(responses.map(response => {
//       if (!response.ok) {
//         throw new Error("Errore nel recupero degli utenti");
//       }
//       return response.json();
//     }));
//     return data.flat();
//   } catch (error) {
//     console.error(error);
//     throw new Error("Errore nel recupero degli utenti");
//   }
// };

 const ContainerCreator/*: React.FC<Props>*/ = (/*{ tipo }*/) => {
//   const [users, setUsers] = useState<object[]>([]);

//   useEffect(() => {
//     const fetchUsers = async () => {
//       try {
//         const data = await getAllUsers(tipo);

//        const mappedData = data.map((user: any) => {
//           if (user.cf && !user.partitaIva) {
//             return new Fisica(
//               user.utenteGeneraleId,
//               user.nome,
//               user.cognome,
//               user.cf,
//               user.sesso,
//               user.genere,
//               user.comuneDiN,
//               user.dataDiN,
//               user.indirizzoFisicaId
//             );
//           } else if (user.partitaIva && !user.cf) {
//             return new Giuridica(
//               user.utenteGeneraleId,
//               user.partitaIva,
//               user.tipo,
//               user.ragioneSociale
//             );
//           } else {
//             return new Individuale(
//               user.utenteGeneraleId,
//               user.nome,
//               user.cognome,
//               user.cf,
//               user.sesso,
//               user.genere,
//               user.comuneDiN,
//               user.dataDiN,
//               user.indirizzoFisicaId,
//               user.partitaIva,
//               user.ragioneSociale
//             );
//           }
//         });
//         setUsers(mappedData);
//       } catch (error) {
//         console.error(error);
//       }
//     };
//     fetchUsers();
//   }, [tipo]);

  return (
    <div className="overflow-y-auto h-full">
      <Container />
      <Container />
      <Container />
      <Container />
      <Container />
      {/* {users.map((user, i) => (
        <Container key={i} user={user} />
      ))} */}
    </div>
  );
};

export default ContainerCreator;