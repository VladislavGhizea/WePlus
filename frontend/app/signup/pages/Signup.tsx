import React from "react";
import { motion } from "motion/react";
import { ActionButton, TextInput } from "../../components/home/buttons";
import { BackButton } from "../../components/signup/buttons";

interface Props {
  onNext: () => void;
}

const Signup: React.FC<Props> = ({ onNext }) => {
  const inputVariants = {
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
    <div className="flex justify-center items-center h-screen w-screen">
      <motion.div
        className="h-[34.5rem] w-[26rem] bg-containerGrey grid grid-rows-5 gap-8 p-8 rounded-3xl shadow-xl"
        initial={{ opacity: 0, y: 50 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.5 }}
      >
        {[
          { text: "Username", type: "text" },
          { text: "Email", type: "email" },
          { text: "Password", type: "password" },
          { text: "Conferma password", type: "password" },
        ].map((input, index) => (
          <motion.div
            key={input.text}
            custom={index}
            initial="hidden"
            animate="visible"
            variants={inputVariants}
          >
            <TextInput text={input.text} type={input.type} />
          </motion.div>
        ))}
        <motion.div
          className="flex justify-between"
          custom={4}
          initial="hidden"
          animate="visible"
          variants={inputVariants}
        >
          <BackButton />
          <ActionButton
            text="Registrati"
            bgColor=" bg-buttonBlue"
            onClick={onNext}
          />
        </motion.div>
      </motion.div>
    </div>
  );
};

export default Signup;
