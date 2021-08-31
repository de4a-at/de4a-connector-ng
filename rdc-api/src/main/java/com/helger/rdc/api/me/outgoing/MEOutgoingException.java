/**
 * Copyright (C) 2021 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.rdc.api.me.outgoing;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.rdc.api.error.IRdcErrorCode;
import com.helger.rdc.api.me.MEException;

/**
 * Exception when sending messages via ME
 *
 * @author Philip Helger
 */
public class MEOutgoingException extends MEException
{
  private final IRdcErrorCode m_aErrorCode;

  protected MEOutgoingException (@Nullable final String sMsg, @Nullable final Throwable aCause, @Nullable final IRdcErrorCode aErrorCode)
  {
    super (sMsg, aCause);
    m_aErrorCode = aErrorCode;
  }

  public MEOutgoingException (@Nullable final String sMsg)
  {
    this (sMsg, null, null);
  }

  public MEOutgoingException (@Nullable final String sMsg, @Nullable final Throwable aCause)
  {
    this (sMsg, aCause, null);
  }

  public MEOutgoingException (@Nonnull final IRdcErrorCode aErrorCode, @Nullable final Throwable aCause)
  {
    this ("RDC Error " + aErrorCode.getID (), aCause, aErrorCode);
  }

  public MEOutgoingException (@Nonnull final IRdcErrorCode aErrorCode, @Nullable final String sMsg)
  {
    this ("RDC Error " + aErrorCode.getID () + " - " + sMsg, null, aErrorCode);
  }

  @Nullable
  public final IRdcErrorCode getErrorCode ()
  {
    return m_aErrorCode;
  }
}
