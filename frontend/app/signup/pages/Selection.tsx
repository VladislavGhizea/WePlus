import SelectionButton from "@/app/components/signup/buttons/SelectionButton";
import { FaUserGraduate } from "react-icons/fa";
import { HiBuildingStorefront, HiDocumentCurrencyEuro } from "react-icons/hi2";
import React from "react";
import { motion } from "motion/react";
import { BackButton } from "@/app/components/signup/buttons";

interface Props {
  onBack: () => void;
}

const Selection: React.FC<Props> = ({ onBack }) => {
  const buttonVariants = {
    hidden: { opacity: 0, y: 50 },
    visible: (i: number) => ({
      opacity: 1,
      y: 0,
      transition: {
        delay: i * 0.3,
      },
    }),
  };

  return (
    <div className="flex flex-col items-center h-screen">
      <div className="absolute top-0 left-0 mt-4 ml-4">
        <BackButton onClick={onBack} />
      </div>
      <h1 className="mt-[10.5rem] text-textBlue text-4xl font-extrabold">
        Seleziona il tipo di account
      </h1>
      <div className="grid grid-flow-col gap-[4rem] mt-[4.5rem]">
        {[
          {
            text: "Persone Fisiche",
            icon: <FaUserGraduate className="h-full w-full" />,
            description: "Persone con validi documenti di identità",
          },
          {
            text: "Persone Giuridiche",
            icon: <HiBuildingStorefront className="h-full w-full" />,
            description: "Aziende con Partita IVA",
          },
          {
            text: "Entità Individuali",
            icon: <HiDocumentCurrencyEuro className="h-full w-full" />,
            description: "Liberi professionisti",
          },
        ].map((button, index) => (
          <motion.div
            key={button.text}
            custom={index}
            initial="hidden"
            animate="visible"
            variants={buttonVariants}
          >
            <SelectionButton
              text={button.text}
              description={button.description}
            >
              {button.icon}
            </SelectionButton>
          </motion.div>
        ))}
      </div>
    </div>
  );
};

export default Selection;
