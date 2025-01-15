"use client";
import SelectionButton from "@/app/components/signup/buttons/SelectionButton";
import { FaUserGraduate } from "react-icons/fa";
import { HiBuildingStorefront, HiDocumentCurrencyEuro } from "react-icons/hi2";
import React, { useState } from "react";
import { motion } from "motion/react";
import { BackButton } from "@/app/components/signup/buttons";
import { MainSnippet } from "@/app/components/signup/snippets";

interface Props {
  onBack: () => void;
}

interface AccountType {
  text: string;
  icon: React.ReactElement;
  description: string;
}

const accountTypes: AccountType[] = [
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
];

const Selection: React.FC<Props> = ({ onBack }) => {
  const [isSnippetVisible, setIsSnippetVisible] = useState(false);
  const [selectedIcon, setSelectedIcon] = useState<React.ReactElement | null>(
    null
  );

  const handleButtonClick = (icon: React.ReactElement) => {
    setSelectedIcon(icon);
    setIsSnippetVisible(true);
  };

  const handleSnippetClose = () => {
    setIsSnippetVisible(false);
    setSelectedIcon(null);
  };

  return (
    <>
      <MainSnippet
        visible={isSnippetVisible}
        parentImage={selectedIcon}
        onClose={handleSnippetClose}
      />
      <div className="flex flex-col items-center h-screen">
        <div className="absolute top-0 left-0 mt-4 ml-4">
          <BackButton onClick={onBack} />
        </div>
        <h1 className="mt-[10.5rem] text-textBlue text-4xl font-extrabold">
          Seleziona il tipo di account
        </h1>
        <div className="grid grid-flow-col gap-[4rem] mt-[4.5rem]">
          {accountTypes.map((account, index) => (
            <motion.div
              key={account.text}
              custom={index}
              initial="hidden"
              animate="visible"
              variants={{
                hidden: { opacity: 0, y: 50 },
                visible: {
                  opacity: 1,
                  y: 0,
                  transition: { delay: index * 0.3 },
                },
              }}
              onClick={() => handleButtonClick(account.icon)}
            >
              <SelectionButton
                text={account.text}
                description={account.description}
              >
                {account.icon}
              </SelectionButton>
            </motion.div>
          ))}
        </div>
      </div>
    </>
  );
};

export default Selection;
