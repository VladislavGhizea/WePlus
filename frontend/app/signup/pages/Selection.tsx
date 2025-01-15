import SelectionButton from "@/app/components/signup/buttons/SelectionButton";
import { FaUserGraduate } from "react-icons/fa";
import { HiBuildingStorefront, HiDocumentCurrencyEuro } from "react-icons/hi2";
import React from "react";
import { BackButton } from "@/app/components/signup/buttons";
interface Props {
  onBack: () => void;
}
const selection: React.FC<Props> = ({ onBack }) => {
  return (
    <div className="flex flex-col items-center h-screen">
      <div className="absolute top-0 left-0 mt-4 ml-4">
        <BackButton onClick={onBack} />
      </div>
      <h1 className="mt-[10.5rem] text-textBlue text-4xl font-extrabold">
        Seleziona il tipo di account
      </h1>
      <div className="grid grid-flow-col gap-[4rem] mt-[4.5rem]">
        <SelectionButton text="Persone Fisiche">
          <FaUserGraduate className="h-12 w-12" />
        </SelectionButton>
        <SelectionButton text="Persone Giuridiche">
          <HiBuildingStorefront className="h-12 w-12" />
        </SelectionButton>
        <SelectionButton text="Entità Individuali">
          <HiDocumentCurrencyEuro className="h-12 w-12" />
        </SelectionButton>
      </div>
    </div>
  );
};

export default selection;
