package seedu.address.logic.parser;


import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.SortCommand.MESSAGE_UNKNOWN_ORDER_KEYWORD;
import static seedu.address.logic.commands.SortCommand.MESSAGE_UNKNOWN_TYPE_KEYWORD;
import static seedu.address.logic.commands.SortCommand.MESSAGE_USAGE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.commands.SortCommand.Order;
import seedu.address.logic.commands.SortCommand.Type;

public class SortCommandParserTest {
    private SortCommandParser parser = new SortCommandParser();

    @Test
    public void parse_validArgs_returnsSortCommand() {
        assertParseSuccess(parser, " NAME ASC", new SortCommand(Type.NAME, Order.ASC));
        assertParseSuccess(parser, " NAME", new SortCommand(Type.NAME, Order.ASC));
        assertParseSuccess(parser, " NAME DESC", new SortCommand(Type.NAME, Order.DESC));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, " UNKNOWN UNKNOWN# UNKNOWN#",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_USAGE));
        assertParseFailure(parser, " UNKNOWN ASC",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_UNKNOWN_TYPE_KEYWORD));
        assertParseFailure(parser, " NAME UNKNOWN",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_UNKNOWN_ORDER_KEYWORD));
    }
}