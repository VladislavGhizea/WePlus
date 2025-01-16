import React, { useState, useEffect } from "react";
import { motion, AnimatePresence } from "motion/react";
import { HiArrowRightEndOnRectangle } from "react-icons/hi2";
import { Section } from "./sections";
import { ActionButton } from "../../home/buttons";

interface Props {
  width: string;
  height: string;
  parentImage: React.ReactNode;
  visible: boolean;
  onClose: () => void;
  onSignUpClick: () => void;
}

const MainSnippet: React.FC<Props> = ({
  width,
  height,
  parentImage,
  visible,
  onClose,
  onSignUpClick,
}) => {
  const [isVisible, setIsVisible] = useState(visible);
  const distanceTop = `calc((100vh - ${height}) / 2)`;
  const distanceLeft = `calc((100vw - ${width}) / 2)`;

  useEffect(() => {
    setIsVisible(visible);
  }, [visible]);

  const handleClose = () => {
    setIsVisible(false);
    onClose();
  };

  return (
    <AnimatePresence>
      {isVisible && (
        <>
          <div
            className="fixed z-10 inset-0 bg-slate-500 bg-opacity-50 backdrop-blur-[2px]"
            onClick={handleClose}
          ></div>

          <motion.div
            className="fixed p-4 bg-containerGrey rounded-3xl shadow-lg z-20"
            style={{
              top: distanceTop,
              left: distanceLeft,
              width: width,
              height: height,
            }}
            initial={{ opacity: 0, y: -10 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0, y: -10 }}
            transition={{ duration: 0.1 }}
          >
            {/* <TbXboxXFilled
              className="absolute top-0 right-0 w-8 h-8"
              onClick={handleClose}
            /> */}
            <div className="grid grid-cols-2 justify-center items-center w-full h-full relative">
              <Section
                image={parentImage}
                button={
                  <ActionButton
                    text="Registrati"
                    bgColor="bg-buttonBlue"
                    width="18rem"
                    onClick={onSignUpClick}
                  />
                }
              >
                Concludi la registrazione
              </Section>
              <div className="absolute left-1/2 transform -translate-x-1/2 h-full w-[1px] rounded-full bg-gray-600"></div>
              <Section
                image={<HiArrowRightEndOnRectangle className=" w-28 h-28" />}
                button={
                  <ActionButton
                    text="Procedi"
                    bgColor="bg-white"
                    width="18rem"
                  />
                }
              >
                Procedi senza concludere la registrazione
              </Section>
            </div>
          </motion.div>
        </>
      )}
    </AnimatePresence>
  );
};

export default MainSnippet;
