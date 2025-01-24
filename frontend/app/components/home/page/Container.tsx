import React from "react";
import { ActionButton, IconButton } from "../buttons";
import { Fisica, Individuale, Giuridica } from "@/app/variables";
import {
  HiOutlineUsers,
  HiOutlineMapPin,
  HiOutlineStar,
  HiOutlineInformationCircle,
} from "react-icons/hi2";
interface Props {
user?: Fisica | Individuale | Giuridica; //TODO rendere non facoltativo in versione finale
}
const Container: React.FC<Props> = (/*{user}*/) => {
 // if (user instanceof Fisica) {
      return (
<div className="grid grid-flow-col items-center mb-2">
      <div className="bg-containerGrey h-[13.5rem] w-[45rem] flex items-center shadow-2xl rounded-3xl relative mt-10 ml-[1rem]">
        <div className="bg-containerGrey font-semibold absolute -top-8 text-4xl rounded-3xl p-2 rounded-bl-none text-textBlue">
          Operaio
        </div>
        <div className="ml-[1.5rem] bg-white h-[10rem] w-[34rem] p-4 rounded-3xl shadow-inner">
          <div className="grid grid-flow-col text-2xl">
            <p className="font-semibold">Mario Rossi </p>
            <p className="ml-10">Età: 30</p>
          </div>
          <div className="h-[1px] w-full bg-darkGrey" />
          <div className="grid grid-flow-col text-2xl mt-2">
            <div className="flex justify-start items-center">
              <HiOutlineUsers />
              <p className="ml-2">Genere: Maschile</p>
            </div>
            <div className="flex justify-start items-center">
              <HiOutlineMapPin />
              <p className="ml-2">Torino</p>
            </div>
          </div>
        </div>
        <div className="grid grid-flow-row justify-items-center gap-5 ml-12">
          <IconButton
            className="p-1 bg-iconGrey rounded-2xl"
            onClick={() => {}}
            icon={<HiOutlineStar className="w-[3rem] h-[3rem] " />}
          />
          <IconButton
            className="p-1 bg-iconGrey rounded-2xl"
            onClick={() => {}}
            icon={<HiOutlineInformationCircle className="w-[3rem] h-[3rem] " />}
          />
        </div>
      </div>
      <div className="flex items-center">
        <ActionButton
          bgColor="bg-buttonBlue"
          text="Contatta"
          className="mt-10"
        />
      </div>
    </div>);
 //   } else if (user instanceof Individuale) {
      // handle Individuale type
//    } else if (user instanceof Giuridica) {
      // handle Giuridica type
  //  }
};

export default Container;
