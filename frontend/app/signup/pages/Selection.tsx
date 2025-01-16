"use client";
import SelectionButton from "@/app/components/signup/buttons/SelectionButton";
import { FaUserGraduate } from "react-icons/fa";
import { HiBuildingStorefront, HiDocumentCurrencyEuro } from "react-icons/hi2";
import React, { useState } from "react";
import { motion } from "motion/react";
import { BackButton } from "@/app/components/signup/buttons";
import { MainSnippet } from "@/app/components/signup/snippets";
import FullSignUpSnippet from "@/app/components/signup/snippets/FullSignUpSnippet";

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
  const [selectedText, setSelectedText] = useState<string | null>(null);

  const handleButtonClick = (icon: React.ReactElement, text: string) => {
    setSelectedIcon(icon);
    setIsSnippetVisible(true);
    setSelectedText(text);
  };

  const handleSnippetClose = () => {
    setIsSnippetVisible(false);
    setSelectedIcon(null);
  };
  const [isSignUpVisible, setIsSignUpVisible] = useState(false);
  const handleSignUpClick = () => {
    setIsSignUpVisible(true);
  };
  const handleSignupClose = () => {
    setIsSignUpVisible(false);
  };

  return (
    <>
      <FullSignUpSnippet
        width="60.5rem"
        height="38.5rem"
        visible={isSignUpVisible}
        parentImage={selectedIcon}
        onClose={handleSignupClose}
        parentText={selectedText as string}
      />
      <MainSnippet
        width="57rem"
        height="32rem"
        visible={isSnippetVisible}
        parentImage={selectedIcon}
        onClose={handleSnippetClose}
        onSignUpClick={handleSignUpClick}
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
              onClick={() => handleButtonClick(account.icon, account.text)}
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
